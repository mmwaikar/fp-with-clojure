(ns examples.core)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;                                                                                                     ;;
;; First see some awesomeness of Clojure.                                                              ;;
;;                                                                                                     ;;
;; 1. Do a C-c C-d C-d over any function, and it gives you the documentation of that Clojure function. ;;
;; 2. Do a M-. over any function and it takes you to the source of that Clojure function.              ;;
;;                                                                                                     ;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def my-vector [1 2 3 4])
(def my-list (list 4 3 2 1))
(def my-map {:name "Manoj" :company "Josh"})

(def hello (fn [] "Hello World"))

(def number-strings ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"])

(defn argcount
  ([] "zero")
  ([x] "one")
  ([x y] "two")
  ([x y & more]
     (get number-strings
          (+ (.indexOf number-strings (argcount x y))
             (count more)))))

(defn immutable-data-structure-ex
  "An example that shows Clojure's immutable data structures."
  []
  (let [v [1 2 3 4]
        l (list 4 3 2 1)
        m {:a 1 :b 2}]
    (list
     (conj v 5)
     (conj l 5)
     (assoc m :c 3)
     v
     l
     m)))

(defn generate-infinite-seqs [n]
  (take n (cycle [1 2 3 4])))

(defmulti encounter (fn [x y] [(:Species x) (:Species y)]))
(defmethod encounter [:Bunny :Lion] [b l] :run-away)
(defmethod encounter [:Lion :Bunny] [l b] :eat)
(defmethod encounter [:Lion :Lion] [l1 l2] :fight)
(defmethod encounter [:Bunny :Bunny] [b1 b2] :mate)

(def b1 {:Species :Bunny :other :stuff})
(def b2 {:Species :Bunny :other :stuff})
(def l1 {:Species :Lion :other :stuff})
(def l2 {:Species :Lion :other :stuff})

;; (encounter b1 b2)
;; :mate

;; (encounter b1 l1)
;; :run-away

;; (encounter l1 l2)
;; :fight

;; (encounter l1 b1)
;; :eat