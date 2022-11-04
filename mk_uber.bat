rem C:\Program Files (x86)\Microsoft Visual Studio\2022\Community\Common7\Tools\vcvars64.bat
rem C:\Program Files\Microsoft Visual Studio\2022\Enterprise\VC\Auxiliary\Build\vcvars64.bat
rem C:\Program Files (x86)\Microsoft Visual Studio\2022\BuildTools\VC\Auxiliary\Build\vcvars64.bat


lein uberjar  
"C:\Program Files\Microsoft Visual Studio\2022\Enterprise\VC\Auxiliary\Build\vcvars64.bat" 
set JAVA_HOME=C:\Program Files\GraalVM\graalvm-ce-java17-22.3.0 

native-image --no-fallback -jar target\default+uberjar\clojuresque-0.1.0-SNAPSHOT-standalone.jar 
