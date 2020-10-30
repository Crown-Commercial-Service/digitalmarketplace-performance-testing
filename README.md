# Digital Marketplace Performance tests

Performance tests for the Digital Marketplace, using [Gatling 3.4](https://gatling.io/docs/3.4/quickstart/).

## Running tests

Make sure you are using Java 8 - run `java -version` to check.

To run a test, run `./bin/gatling.sh`. Choose the scenario you want to run from the menu. See `./bin/gatling.sh --help` for all the options.

Gatling will show the test results on screen and write them to a file.

## Creating and changing tests

Start by reading the [Gatling documentation](https://gatling.io/docs/current/quickstart/). 

The most important files are in the `user-files` directory:

- `resources` contains seed data for API calls, including search terms and supplier IDs
- `simulations` contains the tests, written in Scala.

### Recording a scenario

If you need to create a new user flow to include in your test, a quick way of doing this is to use the [Gatling recorder](https://gatling.io/docs/current/http/recorder/). This allows you to record yourself taking the actions that you want Gatling to perform during the test. You can run it with `./bin/recorder.sh`.

As per the documentation, you should use Firefox. You will need to use a private window to avoid [HSTS](https://en.wikipedia.org/wiki/HTTP_Strict_Transport_Security).

Having finished a recording, you will have an auto-generated Scala file that will run your recording as a test. Tidy this up as necessary - see existing test scenarios as references for how to do this.

## Params

The g-cloud tests accept the following parameters:

        users: number of concurrent users
        rampUp: how quickly to get to max concurrent users (seconds)
        repeat: number of repetitions
        unit: type of repetition [times|seconds]
        minIdle: minimum time between HTTP calls
        maxIdle: maximum time between HTTP calls
        test: Name of Simulation class to run

The following can be read from the environment

        username: for web forms
        password: for web forms
        authHeaderData: for basic auth

## TODO:

- no reports option
- combining several runs

## Generating source data

Seed data for some tests needs to be derived from the database.

### Query for service ids (limited to 1000, active frameworks only):

select service_id as service_id from services join frameworks on (services.framework_id = frameworks.id) where frameworks.expired = false limit 1000

### Query for suppliers (only suppliers who have a service on an active framework):

select distinct(suppliers.supplier_id) as supplier_id from suppliers join services on (suppliers.supplier_id = services.supplier_id) join frameworks on (frameworks.id = services.framework_id) where frameworks.expired = false

### Postgres export as CSV
COPY (:query:) To '/tmp/:filename:' With CSV HEADER;
