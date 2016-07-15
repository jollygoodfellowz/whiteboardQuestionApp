FROM nodesource/fedora22:6.2.0

EXPOSE 5000

ADD package.json package.json

RUN npm install

ADD client/ .
ADD config/ .
ADD server.js .
ADD test_modules/ .
ADD vendor/ .
ADD views/ . 

CMD ["npm","start"]
