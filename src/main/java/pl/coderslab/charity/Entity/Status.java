package pl.coderslab.charity.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String placed ; //= "Zlecenie złożone"//
    private String received; //= "Odebrane przez kuriera"//
    private String transferred; //= "Odebrane przez instytucję"//
    private LocalDate placedDate;
    private LocalDate receivedDate;
    private LocalDate transferredDate;

    public void setPlaced(String placed) {
        this.placed = placed;
    }

    public void setReceived(String received) {
        this.received = received;
    }

    public void setTransferred(String transferred) {
        this.transferred = transferred;
    }

    public String getPlaced() {
        return placed;
    }

    public String getReceived() {
        return received;
    }

    public String getTransferred() {
        return transferred;
    }

    public LocalDate getPlacedDate() {
        return placedDate;
    }

    public void setPlacedDate(LocalDate placedDate) {
        this.placedDate = placedDate;
    }

    public LocalDate getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(LocalDate receivedDate) {
        this.receivedDate = receivedDate;
    }

    public LocalDate getTransferredDate() {
        return transferredDate;
    }

    public void setTransferredDate(LocalDate transferredDate) {
        this.transferredDate = transferredDate;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", placed='" + placed + '\'' +
                ", received='" + received + '\'' +
                ", transferred='" + transferred + '\'' +
                ", placedDate=" + placedDate +
                ", receivedDate=" + receivedDate +
                ", transferredDate=" + transferredDate +
                '}';
    }
}
