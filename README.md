# ngr-ui-tests

## Pre-requisites (for running tests locally)

### Services to run locally

1. **Start Mongo Docker container:**
    ```bash
    docker run --rm -d -p 27017:27017 --name mongo percona/percona-server-mongodb:5.0
    ```

2. **Update the service manager config:**
    ```bash
    sm2 --update-config
    ```

3. **Start NGR services:**
    ```bash
    sm2 --start NGR_ALL --appendArgs '{"NGR_DASHBOARD_FRONTEND":["-Dcentralised-authorisation-resource-client.filter.enabled=false"]}'
    ```

---

## Setting up test data

### Pre-requisites

- **Start the stub:**
    ```bash
    sm2 --start NGR_STUB
    ```

### Populating the Stub

#### Manually Populate Stubs

- **Local environment:**  
  Visit [http://localhost:1503/ngr-dashboard-frontend/test-only/populate-stub-data](http://localhost:1503/ngr-dashboard-frontend/test-only/populate-stub-data) to clear and repopulate stub data.

- **Staging environments:**  
  Visit [https://staging.tax.service.gov.uk/ngr-dashboard-frontend/test-only/populate-stub-data](https://staging.tax.service.gov.uk/ngr-dashboard-frontend/test-only/populate-stub-data) to clear and repopulate stub data.

- **Note:**  
  Completing one login/GG authentication flow when redirected to the above URL will clear and repopulate stub data.

#### Populate Stubs Using Bash Script

1. **Start all NGR services with custom arguments:**
    ```bash
    sm2 --start NGR_ALL --appendArgs '{"NGR_DASHBOARD_FRONTEND":["-Dcentralised-authorisation-resource-client.filter.enabled=false"]}'
    ```

2. **When running ngr-dashboard-frontend locally:**
    ```bash
    sbt run -Dapplication.router=testOnlyDoNotUseInAppConf.Routes \
            -Dcentralised-authorisation-resource-client.filter.enabled=false
    ```
3. Run the script ./run_journey_tests.sh `<JourneyFolder>` `<Environment>` as mentioned in the Running Tests.

---

## Running Tests

### To run the journey tests

```bash
./run_journey_tests.sh `<JourneyFolder>` `<Environment>` 
```
* Argument `<environment>` must be `local`, `dev`, `qa` or `staging`.
```bash
./run_journey_tests.sh Register local
```

### To run an individual spec
```bash
./run_single_spec.sh  `<JourneyFolder>` `<Spec>` `<Environment>`
```
* Argument `<environment>` must be `local`, `dev`, `qa` or `staging`.
```bash
./run_single_spec.sh Register ConfirmContactDetailsSpec local
```

## Scalafmt

Check all project files are formatted as expected as follows:

```bash
sbt scalafmtCheckAll scalafmtCheck
```

Format `*.sbt` and `project/*.scala` files as follows:

```bash
sbt scalafmtSbt
```

Format all project files as follows:

```bash
sbt scalafmtAll
```

## License

This code is open source software licensed under the [Apache 2.0 License]("http://www.apache.org/licenses/LICENSE-2.0.html").
