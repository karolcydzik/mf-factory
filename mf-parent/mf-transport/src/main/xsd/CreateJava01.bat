xjc src\main\xsd\Employee.xsd -extension -npa -b src/main/xsd/global.xjb -d src\main\java
xjc src\main\xsd\Cities.xsd -b src\main\resources\bindings.xjb -extension -d src\main\java -p com.omn.mpfactory.transport.city
xjc src\main\xsd\Cities.xsd -b src\main\xsd\global.xjb -extension -d src\main\java -p com.omn.mpfactory.transport.city