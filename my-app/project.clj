(defproject my-app "0.1.0-SNAPSHOT"
  :description "My App"
  :dependencies [[org.clojure/clojure "1.11.1"]]
  :main ^:skip-aot my-app.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot      :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
