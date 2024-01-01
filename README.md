# mn-trenako

![license](https://img.shields.io/github/license/CarloMicieli/mn-trenako)
![GitHub last commit](https://img.shields.io/github/last-commit/CarloMicieli/mn-trenako)
[![Java CI with Gradle (Kotlin)](https://github.com/CarloMicieli/mn-trenako/actions/workflows/ci.yaml/badge.svg)](https://github.com/CarloMicieli/mn-trenako/actions/workflows/ci.yaml)

A sample app with the Micronaut framework and Java 21.

## How to run

```bash
  git clone https://github.com/CarloMicieli/mn-trenako
  cd mn-trenako
```

## Contributing

Contributions are always welcome!

See `CONTRIBUTING.md` for ways to get started.

Please adhere to this project's `code of conduct`.

### Update the dependency lock state

The project is using the dependency locking, in order to update the persisted state run:

```bash
  ./gradlew :libs:util:dependencies --write-locks
  ./gradlew :modules:common:dependencies --write-locks
  ./gradlew :modules:catalog:dependencies --write-locks
  ./gradlew :services:webapi:dependencies --write-locks
```

### Conventional commits

This repository is following the conventional commits practice.

#### Enforcing using git hooks

```bash
  chmod +x .githooks/commit-msg
  git config core.hooksPath .githooks
```

The hook itself can be found in `.githooks/commit-msg`.

#### Using Commitizen

Install [commitizen](https://github.com/commitizen-tools/commitizen)

```bash
  pip install commitizen
```

and then just use it

```bash
  cz commit
```

## License

[Apache 2.0 License](https://choosealicense.com/licenses/apache-2.0/)

```
   Copyright 2023 Carlo Micieli

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```
