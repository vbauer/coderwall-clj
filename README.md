# coderwall-clj

[![Build Status](https://travis-ci.org/vbauer/coderwall-clj.svg?branch=master)](https://travis-ci.org/vbauer/coderwall-clj)
[![Dependencies Status](http://jarkeeper.com/vbauer/coderwall-clj/status.png)](http://jarkeeper.com/vbauer/coderwall-clj)

Tiny Clojure client library for [coderwall.com](https://coderwall.com) REST [API](https://coderwall.com/api).


## Installation

**coderwall-clj** is available as a Maven artifact from [Clojars](https://clojars.org).
To add it into your project, put the following line in the `:dependencies` vector in your `project.clj` file:

![latest-version](https://clojars.org/coderwall-clj/latest-version.svg)


## Usage

All functionality is provided by the coderwall-clj.client namespace.

First, require it in the REPL:
```clojure
(require '[coderwall-clj.client :as coderwall])
```

Or in your application:
```clojure
(ns my-app.core
  (:require [coderwall-clj.client :as coderwall]))
```

The client has 2 simple methods:

* **user-url** to retrieve API URL.
* **user-data** to fetch information about user.

### user-url [user-name]

To build API URL for user, use the following code:
```clojure
(coderwall/user-url "vbauer")

; It is also possible to use keyword as username:
(coderwall/user-url :vbauer)
```

Result output:
```clojure
"https://coderwall.com/vbauer.json"
```

### user-data [user-name]

To fetch full information about user, use:
```clojure
(coderwall/user-data "vbauer")

; It is also possible to use keyword as username:
(coderwall/user-data :vbauer)
```

Result output:
```clojure
{ :name "Vladislav Bauer"
  :username "vbauer"
  :title ""
  :specialities []
  :thumbnail "https://coderwall-assets-0.s3.amazonaws.com/uploads/user/avatar/105055/52a677364752793dda3929cf8e4975ce.jpeg"
  :team nil
  :badges [ { :name "Lemmings 100"
              :description "Write something great enough to have at least 100 watchers of the project"
              :created "2014-06-11T19:27:37Z"
              :badge "https://d3levm2kxut31z.cloudfront.net/assets/badges/100lemming-312e3bc30f6814302412a3ec1dcf7896.png" }
            { :name "Forked 100"
              :description "Have a seriously badass project that's been forked at least 100 times"
              :created "2014-06-11T19:27:37Z"
              :badge "https://d3levm2kxut31z.cloudfront.net/assets/badges/forked100-0e5ee0a84ad371c85ba66246a3952f75.png" }
            ; etc.
          ]
  :endorsements 0
  :location "Russia, Novosibirsk"
  :accounts { :github "vbauer"
              :twitter "BauerVlad" }
  :company ""
  :about "If you can dream it, you can do it." }
```

To fetch short information about user without extra details:
```clojure
(coderwall/user-data :vbauer false)
```


## Might also like

* [lein-asciidoctor](https://github.com/asciidoctor/asciidoctor-lein-plugin) - a Leiningen plugin for generating documentation using Asciidoctor.
* [lein-plantuml](https://github.com/vbauer/lein-plantuml) - a Leiningen plugin for generating UML diagrams using PlantUML.
* [lein-jshint](https://github.com/vbauer/lein-jshint) - a Leiningen plugin for running javascript code through JSHint.
* [lein-jslint](https://github.com/vbauer/lein-jslint) - a Leiningen plugin for running javascript code through JSLint.
* [lein-coffeescript](https://github.com/vbauer/lein-coffeescript) - a Leiningen plugin for running CoffeeScript compiler.
* [lein-typescript](https://github.com/vbauer/lein-typescript) - a Leiningen plugin for running TypeScript compiler.
* [jabberjay](https://github.com/vbauer/jabberjay) - a simple framework for creating Jabber bots.


## License

Copyright © 2015 Vladislav Bauer

Distributed under the Eclipse Public License, the same as Clojure.
