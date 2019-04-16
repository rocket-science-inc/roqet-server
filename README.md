# Welcome to the roqet-server

1) You have to modify the following file: src/main/resources/application.properties

2) run in console: mvn spring-boot:run


GraphiQL issue: Uncaught Error: Mode graphql failed to advance stream.
Solution - run in console: localStorage.clear(); localStorage.setItem = () => {}