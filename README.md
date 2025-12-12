# ngr-ui-tests

### Pre-requisites (for running tests on local)

### Services to run locally:

Start Mongo Docker container as follows:

```bash
docker run --rm -d -p 27017:27017 --name mongo percona/percona-server-mongodb:5.0
```
Update the service manager config as follows:

```bash
sm2 --update-config
```
Start NGR services as follows:
```bash
sm2 --start NGR_ALL --appendArgs '{"NGR_DASHBOARD_FRONTEND":["-Dcentralised-authorisation-resource-client.filter.enabled=false"]}'
```

## Setting up test data
### Pre-requisites

Run the following command to get the stub running:

`sm2 --start NGR_STUB`

### Populating the stub

- **To populate the stubs with data and run the bash script:**
    1. **Local environment:**
       Load the URL `http://localhost:1503/ngr-dashboard-frontend/test-only/populate-stub-data` which will clear all existing stub data and repopulate it.
    2. **Staging environments:**
       Load the URL `https://staging.tax.service.gov.uk/ngr-dashboard-frontend/test-only/populate-stub-data` which will clear all existing stub data and repopulate it.
    3. Complete one login/GG authentication flow when redirected to and visiting the above URL will clear all existing stub data and repopulate it.
            
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
