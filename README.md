# booking-lite

##Note: Assumptions and understandings Established
1. Since Vehicle count is expected to be >10000, 'Vehicle' entity management was ommited and a custom Vehicle Number generator is used to establish Outcome.
2. Cities and Booking entities are managed to track count of vehicles.
3. Fares are hard-coded during the intialization process.
4. Cities hard-coded during Intialization are "Delhi", "Mumbai", "Bangalore", "Test-1" and "Test-2"
5. Travel time between all cities is assumed to be 1 day

##How to build and run the program?
1. Clone the repository into local
2. Create a database schema with schema name: 'BOOKINGDB'
3. Update the mysql credentials in the following files in module 'booking-lite-db' and module 'booking-lite-api' respectively.
   <br>a) localhost.properties b) application.yaml
4. (Build the 'booking-lite-db' module) Navigate to the module 'booking-lite-db' and run the following command on terminal
   <br> ' mvn install -Psetup ' (Profile mentioned in the pom.xml is "SETUP")
5. (Build the 'booking-lite-service' module) Navigate to the module 'booking-lite-service' and run the following command on terminal
   <br> ' mvn install '
6. (Build the 'booking-lite-service' module) Navigate to the module 'booking-lite-api' and run the following command on terminal
   <br> ' mvn install '
7. On successfull build, run the 'BookingApplicationAPI.Java' file to run the program.

##Intialization and API access
1. Swagger UI has been implemented for API documentation. Same can be used to access the APIs.
2. Access using the following URL on your browser 
    <br> ' http://localhost:8080/booking-api/swagger-ui.html '
3. Run the 'init' API endpoint on the first instance of running the application.
4. Create bookings using the '/booking' endpoint here on! Yay!

< Hint: Uncomment the 'BookingControllerTest.java' file to run the test cases !>

##Requirements
1. Apache Maven 3.6+
2. Java 8 (jdk 1.8)
