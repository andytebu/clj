(ns learn-clojure-tutorial.sintax)
;; https://clojure.org/guides/learn/syntax

;; Using the REPL, compute the sum of 7654 and 1234.
(+ 7654 1234)

;; Rewrite the following algebraic expression as a Clojure expression: ( 7 + 3 * 4 + 5 ) / 10.
(/ (+ 7 (* 3 4) 5) 10)

;; Using REPL documentation functions, find the documentation for the rem and mod functions. Compare the results of the provided expressions based on the documentation.
(require '[clojure.repl :as repl :refer [doc find-doc pst]])

;; Using REPL documentation functions, find the documentation for the rem and mod functions. Compare the results of the provided expressions based on the documentation.
(doc rem)
(doc mod)
(doc /)
(/ 12)
(/ 12 5 2)

;; Using find-doc, find the function that prints the stack trace of the most recent REPL exception.
(find-doc "stack trace")
(pst)