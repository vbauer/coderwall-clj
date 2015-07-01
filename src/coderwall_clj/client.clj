(ns ^{:author "Vladislav Bauer"}
  coderwall-clj.client
  (:require [clj-http.client :as http]))


(def ^:dynamic API_URL "https://coderwall.com/")
(def ^:dynamic FORMAT ".json")
(def ^:dynamic HTTP_CONFIG
  {:as :json
   :accept :json
   :insecure? true
   :throw-exceptions true
   :socket-timeout 10000
   :conn-timeout 10000})


(defn user-url [user-name]
  (str API_URL (name user-name) FORMAT))

(defn user-data
  ([user-name]
   (user-data user-name true))
  ([user-name full]
   (let [url (user-url user-name)
         query-params {:query-params {:full full}}
         config (merge HTTP_CONFIG query-params)
         response (http/get url config)]
     (:body response))))
