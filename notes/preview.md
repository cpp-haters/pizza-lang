##### Simple Preview

```
Application:
    Sources => Interpreter,
    Interpreter => Scripts {
        Script <= Parsers,
        Script <= Analyzer,
        Application <= Script
    }
    Launch
```