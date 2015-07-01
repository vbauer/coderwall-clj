(defproject coderwall-clj "0.1.0-SNAPSHOT"
  :description "CoderWall client for Clojure"
  :url "https://github.com/vbauer/coderwall-clj"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo}

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [clj-http "1.1.2"]]

  :global-vars {*warn-on-reflection* false}
  :min-lein-version "2.0.0")
