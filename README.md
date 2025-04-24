# ngr-ui-tests

### Pre-requisites (for running tests on local)

### Services to run locally:

Start Mongo Docker container as follows:

```bash
docker run --rm -d -p 27017:27017 --name mongo percona/percona-server-mongodb:5.0
```

Start NGR services as follows:

```bash
sm2 --start NGR_ALL
```
### To run the tests
```bash
./run_tests.sh `<environment>`
```
* Argument `<environment>` must be `local`, `dev`, `qa` or `staging`.
```bash
./run_tests.sh staging
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

## Setting up test data
### Pre-requisites

Run the following command to get the stub running:

`sm2 --start NGR_STUB`
### Populating the stub
To populate the stubs with data, run the following:
`./populate_stub.sh`
It accepts the following parameter:

`$1` the Environment to run against. Valid Options: `local` & `staging` Default: `local`
#### Test Data Available
CredId     | Code | Description      
:-------   |:-----|:-----------------
1237891256 | 200  | RatePayerWithAllData
12378912   | 200  | EmailNotSupplied
12378912678| 200  | No Phone Number 
1237891267812  | 200  | RatePayer with no data

## License

This code is open source software licensed under the [Apache 2.0 License]("http://www.apache.org/licenses/LICENSE-2.0.html").
