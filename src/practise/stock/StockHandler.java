package practise.stock;

import practise.Practise;

import java.util.ArrayList;

enum Item {
    BEAKER,
    COTTON_PAD
}

public class StockHandler {
    private Practise practise;
    private ArrayList<StockItem> stock;

    public StockHandler(Practise practise) {
        this.practise = practise;
    }

    public void buy(Item item, int amount, double pricePerPiece) {
        for (StockItem i : stock) {
            if (i.getItem().equals(item)) {
                i.increaseStock(amount);
                practise.decreaseBudget(amount * pricePerPiece);
                return;
            }
        }
        stock.add(new StockItem(item, amount));
        practise.decreaseBudget(amount * pricePerPiece);
    }
}
