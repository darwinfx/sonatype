# Sonatype Interview Darwin Betancur

Sonartype interview - Convert numbers to words

## Installation

You can use an IDE to run it, or running with command line.

In root application folder, execute:
```bash
mvn package && java -jar target/interview-0.0.1-SNAPSHOT.jar
```

## Usage
Swagger API is used to make request to the application.

http://localhost:8080/swagger-ui.html#!/Converter/createUsingGET

## Application Boundaries
#####Number Range
```bash
-999.999.999.999.999 < number > 999.999.999.999.999
```
#####Negative Simbol
```bash
Negative values allowed just only at the begining of value:
Valid numbers:
-1, -23232, -00000002, -1,000.000

Invalid Numbers:
1-, Negative 3, --5,

```
#####Decimal Simbol
```bash
Comma (,), any other non-number simbol throws error, except negative symbol (-)
```

## Response Examples
####Response OK:
```bash
{
  "result": {
    "value": "236223",
    "word": "two hundred thirty six thousand two hundred and twenty three"
  },
  "status": "OK",
  "message": null
}
```
####Response ERROR: Number sent: 2362,23
```bash
{
  "result": null,
  "status": "NOT_ACCEPTABLE",
  "message": "java.lang.NumberFormatException: Decimal simbols in wrong position"
}

```

####Response ERROR:
```bash
{
  "result": null,
  "status": "NOT_ACCEPTABLE",
  "message": "java.lang.NumberFormatException: For input string: \"1123A\""
}

```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License