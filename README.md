# Digital Marketplace Performance tests

Based on gatling [http://gatling.io/docs/2.1.6/quickstart.html](http://gatling.io/docs/2.1.6/quickstart.html)

## Layout:

Important files are:

        - simulation.conf: holds basic config (see Params section below)

All files under the user-files/ directory:

        - bodies: these is the JSON bodies used in API calls
        - data: these are seed data for calls - for example search terms or supplier IDs
        - simulations: these are the actual performance tests

Simulations:

These are held in 2 folders:

        - scenarios: these are the actual raw tests that can be executed - for example fetch services by page
        - simulations: these are combinations of scenarios - these are based to the command line scripts -
        so for example we may want to run a tests where we combine fetching and update services. We would have a simulation that refers to two scenarios.


### Examples

Scenario:

          val fetchServices = scenario("FetchServices")
            .keepRepeating {
            feed(randomPage)
              .exec(http("FetchServices")
              .get("/services?page=${random_page}")
              .check(status.is(200))
              ).pause(minIdleTime milliseconds, maxIdleTime milliseconds)
          }


Single Simulation (import services):

        class DataApiImportServicesSimulation extends Simulation with DigitalMarketplaceHttpConf {
          setUp(importServices.inject(atOnceUsers(numberOfUsers)).protocols(dataApiHttpConf))
        }

Combined Simulation (update services whilst fetching):

        class DataApiUpdateAndFetchServicesSimulation extends Simulation with DigitalMarketplaceHttpConf {
          setUp(
            updateServices.inject(atOnceUsers(numberOfUsers)).protocols(dataApiHttpConf),
            fetchServices.inject(atOnceUsers(numberOfUsers)).protocols(dataApiHttpConf)
          )
        }

## Feeders

the custom feeder class creates seed data - either from file or generated in class for use in scenarios

## Running tests

Make sure you are using Java 8, then run:

```
./scripts/run-gatling.sh --test GCloud12Application
```

### Params

        users: number of concurrent users
        rampUp: how quickly to get to max concurrent users (seconds)
        repeat: number of repetitions
        unit: type of repetition [times|seconds]
        minIdle: minimum time between HTTP calls
        maxIdle: maximum time between HTTP calls
        test: Name of Simulation class to run

### Additional Params

the following can be read from the environment

        username: for web forms
        password: for web forms
        authHeaderData: for basic auth

## Configuration

the simulation.conf contains basic setup. includes bearer tokens, urls and defaults for the above parameters.

## Test Results

These are summarised onscreen and also there is an reports directory for graphical representation

### TODO:

- no reports option
- combining several runs


## Generating source Data

Seed data for some tests needs to be derived from the database.

### Query for service ids (limited to 1000, active frameworks only):

select service_id as service_id from services join frameworks on (services.framework_id = frameworks.id) where frameworks.expired = false limit 1000

### Query for suppliers (only suppliers who have a service on an active framework):

select distinct(suppliers.supplier_id) as supplier_id from suppliers join services on (suppliers.supplier_id = services.supplier_id) join frameworks on (frameworks.id = services.framework_id) where frameworks.expired = false

### Postgres export as CSV
COPY (:query:) To '/tmp/:filename:' With CSV HEADER;
