# coderwall-clj

[![Build Status](https://travis-ci.org/vbauer/coderwall-clj.svg?branch=master)](https://travis-ci.org/vbauer/coderwall-clj)
[![Clojars Project](https://img.shields.io/clojars/v/coderwall-clj.svg)](https://clojars.org/coderwall-clj)

Tiny Clojure client library for [coderwall.com](https://coderwall.com) REST [API](https://coderwall.com/api).


## Installation

**coderwall-clj** is available as a Maven artifact from [Clojars](https://clojars.org).
To add it into your project, put the following line in the `:dependencies` vector in your `project.clj` file:

```clojure
; Use latest version instead of "X.X.X"
:dependencies [[coderwall-clj "X.X.X"]]
```


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
{:user
 {:name "Vladislav Bauer",
  :username "vbauer",
  :karma 119,
  :title "",
  :specialities [],
  :thumbnail
  "https://coderwall-assets-0.s3.amazonaws.com/uploads/user/avatar/105055/52a677364752793dda3929cf8e4975ce.jpeg",
  :team nil,
  :id 105055,
  :badges
  [{:name "Lemmings 100",
    :description
    "Write something great enough to have at least 100 watchers of the project",
    :created_at "2014-06-11T19:27:37.729Z",
    :badge
    "https://d1ujcb8mxkwm85.cloudfront.net/assets/badges/100lemming-75ef69b417fed814e00911c952268ec8f46e670b2b7f1d3197e95e531530c5f3.png"}
   {:name "Forked 100",
    :description
    "Have a seriously badass project that's been forked at least 100 times",
    :created_at "2014-06-11T19:27:37.465Z",
    :badge
    "https://d1ujcb8mxkwm85.cloudfront.net/assets/badges/forked100-eb3235ebeb00483ef070677bead3e2c4037d5b3f9197d3f6c524a0b0bf185587.png"}
   {:name "Mongoose 3",
    :description
    "Have at least three original repos where Ruby is the dominant language",
    :created_at "2014-06-11T19:27:36.496Z",
    :badge
    "https://d1ujcb8mxkwm85.cloudfront.net/assets/badges/mongoose3-3c4898df9b91ea4bec8bce0c83908998df630cbbf749d2dcfadba121af2bf1fa.png"}
   {:name "Narwhal 3",
    :description
    "Have at least three original repos where Clojure is the dominant language",
    :created_at "2014-06-11T19:27:36.232Z",
    :badge
    "https://d1ujcb8mxkwm85.cloudfront.net/assets/badges/narwhal3-847117acebb115e6af72745807626e70f2fd591c45dc5d32caef41fbd0297029.png"}
   {:name "Walrus",
    :description
    "The walrus is no stranger to variety. Use at least 4 different languages throughout all your repos",
    :created_at "2014-04-18T14:41:59.288Z",
    :badge
    "https://d1ujcb8mxkwm85.cloudfront.net/assets/badges/walrus-1f517cbbd8f030099b8386c53d4ee40fece3fa146b6362accb3abddb436482cb.png"}
   {:name "Komodo Dragon",
    :description
    "Have at least one original repo where Java is the dominant language",
    :created_at "2014-04-12T16:53:40.176Z",
    :badge
    "https://d1ujcb8mxkwm85.cloudfront.net/assets/badges/komododragon-4a367331904f40950f6ad91fe236c48eec07fe8e0087471dbf7a17c6c6ed7923.png"}
   {:name "Charity",
    :description
    "Fork and commit to someone's open source project in need",
    :created_at "2014-04-12T16:53:39.855Z",
    :badge
    "https://d1ujcb8mxkwm85.cloudfront.net/assets/badges/charity-bab6d575c53894cc9e395db7cdb1f0f91f176fa0cc8122c5f824e672f3d556a4.png"}],
  :endorsements 119,
  :location "Russia, Novosibirsk",
  :accounts {:github "vbauer", :twitter "BauerVlad"},
  :company "",
  :about
  "If you can dream it, you can do it.\n\n\n[LinkedIn](http://www.linkedin.com/in/vladislavbauer) [Blog](http://twitter.com/BauerVlad) [Bitbucket](https://bitbucket.org/vbauer) [StackOverflow](http://stackoverflow.com/users/847626)\n\n"}}
```

To fetch short information about user without extra details:
```clojure
(coderwall/user-data :vbauer false)
```

To override HTTP client configuration:
```clojure
(coderwall/user-data
 :vbauer true
 { :as :json
   :accept :json
   :insecure? true
   :socket-timeout 60000
   :conn-timeout 60000 })
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
