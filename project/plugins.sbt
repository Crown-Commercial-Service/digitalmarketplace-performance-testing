resolvers ++= Seq(
    "sbt-idea-repo" at "http://mpeltonen.github.com/maven/",
     "Typesafe releases" at "http://repo.typesafe.com/typesafe/releases"
)

addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.5.2")

addSbtPlugin("com.typesafe.sbt" % "sbt-scalariform" % "1.2.1")

