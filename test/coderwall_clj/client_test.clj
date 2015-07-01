(ns coderwall-clj.client-test
  (:require [clojure.test :refer :all]
            [coderwall-clj.client :refer :all]))

(deftest test-user-url
  (testing "Check user-url function"
    (is (= (user-url "vbauer") "https://coderwall.com/vbauer.json"))))

(deftest test-user-data
  (testing "Check user-data function"
    (let [data (user-data "vbauer")]
      (is (not (nil? data)))
      (is (:username data) "vbauer")
      (is (:name data) "Vladislav Bauer"))))
