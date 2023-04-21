package Model;

import java.util.ArrayList;
import java.util.List;

public class Review {
    private int id;
    private int rating;
    private String description;
    private int clientId;
    private int productId;
    private List<Review> listOfReviews = new ArrayList<>();

    public Review(int id, int rating, String description, int clientId, int productId) {
        this.id = id;
        this.rating = rating;
        this.description = description;
        this.clientId = clientId;
        this.productId = productId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public List<Review> getListOfReviews() {
        return listOfReviews;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                ", clientId=" + clientId +
                ", productId=" + productId +
                '}';
    }
}
