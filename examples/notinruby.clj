(ns examples.notinruby)

(defn constrained-fn [f x]
  {:pre  [(pos? x)]
   :post [(= % (* 2 x))]}
  (f x))

;; (constrained-fn #(* 2 %) 3)

;; (constrained-fn #(* 2 %) -1)
;; Assert failed: (pos? x)
;;     [Thrown class java.lang.AssertionError]

;; (constrained-fn #(* 3 %) 2)
;; Assert failed: (= % (* 2 x))
;;     [Thrown class java.lang.AssertionError]

(defn destr-seq [[a b & more]]
  (str "Got " a ", " b ", and " more))

;; (destr-seq [1 2])
;; "Got 1, 2, and "

;; (destr-seq [1 2 3 4])
;; "Got 1, 2, and (3 4)"

(defn destr-map [{p1 :player1 p2 :player2}]
  [p1 :vs p2])

;; (destr-map {:player1 "Mike", :player2 "Chris"})
;; ["Mike" :vs "Chris"]