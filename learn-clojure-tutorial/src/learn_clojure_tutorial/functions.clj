(ns learn-clojure-tutorial.functions)
;; https://clojure.org/guides/learn/functions

;; ;; Define a function greet that takes no arguments and prints "Hello". Replace the ___ with the implementation: (defn greet [] _)
(defn greet [] (println "Hello"))
(greet)

;; using fn
(def greet-fn (fn [] (println "Hello")))
(greet-fn)

;; using #()
(def greet-h #(println "Hello"))
(greet-h)

;; Hint use the str function to concatenate strings

(require '[clojure.repl :as repl :refer [doc findsí-doc source pst]])
(doc str)

(defn greeting
  ([] (str "Hello, World!"))
  ([x] (str "Hello, " x "!"))
  ([x y] (str x ", " y "!")))

;; For testing
(assert (= "Hello, World!" (greeting)))
(assert (= "Hello, Clojure!" (greeting "Clojure")))
(assert (= "Good morning, Clojure!" (greeting "Good morning" "Clojure")))

;;  Define a function do-nothing which takes a single argument x and returns it, unchanged.
(defn do-nothing
  [x] x)
(do-nothing 13)

;; In Clojure, this is the identity function. By itself, identity is not very useful, but it is sometimes necessary when working with higher-order functions.
(source identity)

;; Define a function always-thing which takes any number of arguments, ignores all of them, and returns the number 100.
(defn always-thing
  [& _] 100)
(always-thing)

;; Define a function make-thingy which takes a single argument x. It should return another function, which takes any number of arguments and always returns x.
(defn make-thingy
  [x]
  (fn [& _] x))

;; Tests
(let [n (rand-int Integer/MAX_VALUE)
      f (make-thingy n)]
  (assert (= n (f)))
  (assert (= n (f 123)))
  (assert (= n (apply f 123 (range)))))

;; In Clojure, this is the constantly function.
(source constantly)

;; Define a function triplicate which takes another function and calls it three times, without any arguments.
(defn triplicate
  [f] (f) (f)
  (f))

(triplicate greet)


;; Define a function opposite which takes a single argument f. It should return another function which takes any number of arguments, applies f on them, and then calls not on the result. The not function in Clojure does logical negation
(defn opposite [f]
  (fn [& args]
    (not
     (apply f args))))

(defn is-even? [x]
  (zero? (rem x 2)))

((opposite complement) '(true false false false true))
((opposite is-even?) 13)
((opposite is-even?) 14)



(doc find-doc)
(find-doc "stacktrace")
(pst)
(type '(true false))
(source or)


(defn triplicate2 [f & args]
  (triplicate (f args)))

(triplicate2 (fn [& args] (apply + args))) 1 2 3 4 5 6 7 8 9 10)

(doc +)
(+ 1 2 2 3 4 5 6 7 8 9 10)


(source +)