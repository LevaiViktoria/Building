package hu.validation.exceptions;

public class BuildingAlreadyExistException extends RuntimeException{
    private String message;

    public BuildingAlreadyExistException(String address) {
        this.message = "The building on this address: " + address+ "already,exist";

    }

    @Override
    public String toString() {
        return "BuildingAlreadyExistException{" +
                "message='" + message + '\'' +
                '}';
    }
}
