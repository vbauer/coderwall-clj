(ns coderwall-clj.client-test
  (:require [clojure.test :refer :all]
            [coderwall-clj.client :as coderwall]))

(deftest test-user-url
  (testing "Check user-url function"
    (is (= (coderwall/user-url "vbauer")
           "https://coderwall.com/vbauer.json"))))

(deftest test-user-data
  (testing "Check user-data function"
    (let [data (coderwall/user-data "vbauer" true)
          user (:user data)]
      (is (:username user) "vbauer")
      (is (:name user) "Vladislav Bauer"))))
