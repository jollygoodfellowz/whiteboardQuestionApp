FROM nodesource/fedora22:6.2.0
ADD package.json package.json
RUN npm install

ADD client/ .
ADD config/ .
ADD server/ .
ADD server.js .
ADD test_modules/ .
ADD vendor/ .
ADD views/ . 

CMD ["npm","start"]
