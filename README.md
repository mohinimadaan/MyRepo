[# MyRepo]
(http://localhost:8080/theatres GET
http://localhost:8080/theatres/1 GET
http://localhost:8080/theatres/3 GET == show exception
http://localhost:8080/theatres POST == add theatre and movie
http://localhost:8080/theatres/3/saveMovie POST == add movie in existing theatre


http://localhost:8080/movies GET
http://localhost:8080/movies/1 GET
http://localhost:8080/movies/1 GET  == show exception

http://localhost:8080/movies/booking?movieId=1&noOfTickets=2&totalPrice=800  POST  == book movies
http://localhost:8080/movies/booking/history GET == booking history
)
