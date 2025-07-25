# Java and Clojure base image
FROM clojure:temurin-21-tools-deps

WORKDIR /app

COPY deps.edn .

RUN clojure -P

COPY . .

CMD ["clojure", "-M"]