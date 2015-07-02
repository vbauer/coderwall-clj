(defproject coderwall-clj "0.1.0-SNAPSHOT"
  :description "CoderWall client for Clojure"
  :url "https://github.com/vbauer/coderwall-clj"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo
            :comments "Same as Clojure"}

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [clj-http "1.1.2"]]

  :profiles {:prod {:plugins [[lein-release "1.0.6" :exclusions [org.clojure/clojure]]]
                    :scm {:name "git"
                          :url "https://github.com/vbauer/coderwall-clj"}
                    :lein-release {:deploy-via :clojars
                                   :scm :git}}}

  :checksum :warn
  :global-vars {*warn-on-reflection* false}
  :min-lein-version "2.0.0")
