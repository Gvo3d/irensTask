docker run --name multimedia -p 5432:5432 -e POSTGRES_USER=multimedia -e POSTGRES_PASSWORD=root -d postgres:9.6
java -jar ROOT.jar