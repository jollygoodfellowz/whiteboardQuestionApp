var request = require("request");
var mongodb = require('mongodb');
var express = require('express');
var fs = require('fs');
var multiparty = require('connect-multiparty')
var html = require('html');
var ejs = require('ejs');
var exec = require('child_process').exec;
var process = require('process');
var multipartyMiddleware = multiparty();

app = express();
app.set('views', __dirname + '/views/');

// Use these folders for static assets
app.use(express.static('views'));
app.use(express.static('vendor'));
app.use(express.static('client'));
app.use(express.static('node_modules'));
app.engine('html', require('ejs').renderFile);

//We need to work with "MongoClient" interface in order to connect to a mongodb server.
var MongoClient = mongodb.MongoClient;

// Connection URL. This is where your mongodb server is running.
var url = 'mongodb://localhost:27017/InterviewDB';
var collection = 'problemsDB';

// function for grabbing the whole DB
var problems = function(db, callback) {
}; 


app.get('/', function(req, res) {
    res.render(app.settings.views + "index.html");
});
app.listen(3030);

// Upload the java file
app.post('/file', multipartyMiddleware, function(req, res) {

    var startDir = __dirname;

    if(req.files.file) {
        // Get the name of the file uploaded
        filename = req.files.file.name;
        file = filename.split('.');
        f = file[0];

        // Test module name 
        testPath = "test_modules/";

        testModule = req.body.problem.name + "Test";

        // Save the uploaded file
        fs.readFile(req.files.file.path, function (err, data) {
            var newPath = testPath + "uploads/" + filename;
            fs.writeFile(newPath, data, function (err) {

                // Compile the source file and the test module
                var buildDir = testPath + "build/";
                var testFile = testPath + testModule + ".java";
                var javac = "javac -d " + buildDir + " " + testFile + " " + newPath;

                exec(javac, (error, stdout, stderr) => {
                    if(error) {
                        res.json(`error in compiling ${error}`);
                        console.error(`exec error: ${error}`);
                        return;
                    }
                    
                    // Change to the build directory        
                    process.chdir(buildDir);

                    // Run the compiled class file
                    var java = 'java ' + testModule;
                    exec(java, (error, stdout, stderr) => {
                        if(error) {
                            console.error(`exec error: ${error}`);   
                            // TODO: Need to trim this before sending it back
                            res.json(`java run time error: ${error}`);   
                        }

                        // The program ran without any errors
                        else if(stdout) {
                            var json = JSON.stringify(stdout);
                            // If the output matches what is in the database it is correct
                            if(stdout == req.body.problem.text) {
                                res.json("Correct!");
                            } else {
                                res.json("Incorrect");
                            }
                        }

                        // Delete the class files
                        var rm = "rm " + f + "* | rm ../uploads/" + f + "*";
                        exec(rm, (error, stdout, stderr) => {
                            if(error) {
                                console.error(`exec error: ${error}`);
                            }
                        });

                        // Need to change back to the original directory
                        process.chdir(startDir);
                    });
                });
            });
        });
    }
});

function getProblems(res, problems) {
    MongoClient.connect(url, function (err, db) {
            var data = db.collection(collection).find(problems).toArray(function(err, result) {
                if(err) {
                    console.log(err);
                }
                else if(result.length) {
                    res.json(result);
                    console.log(result);
                }
                db.close();
            });
    });
}
// Grab the problems from the data base
app.get('/problems', function(req, res) {
    getProblems(res);    
});

app.get('/problem', function(req, res, problem) {
    getProblems(res, problem);
});

// Console will print the message
console.log('Server running at http://127.0.0.1:3030/');
