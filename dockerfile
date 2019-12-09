FROM java:8
WORKDIR /
ADD ./target/twitter-hashtag-search-0.0.1-SNAPSHOT.jar /home/twitter-hashtag-search-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD java -jar /home/twitter-hashtag-search-0.0.1-SNAPSHOT.jar