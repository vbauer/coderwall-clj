(ns ^{:author "Vladislav Bauer"}
  coderwall-clj.client
  (:require [clj-http.client :as http]))


; Constants

(def ^:dynamic api-url "https://coderwall.com/")
(def ^:dynamic output-format-extension ".json")
(def ^:dynamic http-client-config
  {:as :json
   :accept :json
   :insecure? true
   :throw-exceptions true
   :follow-redirects true
   :max-redirects 3
   :socket-timeout 10000
   :conn-timeout 10000
   :debug false})


; Functions

(defn ^:dynamic user-url
  "Build URL to the Coderwall API to fetch information about user."
  [user-name]
  (let [user (name user-name)]
    (str api-url user output-format-extension)))

(defn user-data
  "Fetch information about Coderwall user via REST API."
  ([user-name]
   (user-data user-name true))
  ([user-name full?]
   (user-data user-name full? http-client-config))
  ([user-name full? http-config]
   (let [url (user-url user-name)
         query-params {:query-params {:full full?}}
         config (merge http-config query-params)
         response (http/get url config)]
     (:body response))))
