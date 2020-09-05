package third;

public class BookTest {
    public static void main(String[] args) {
        Book prata = new Book("Prata", "Prata c++", 2010);
        System.out.printf("Author: %s , Name: %s, Year of writting: %s \n",
                          prata.getAuthor(), prata.getName(), prata.getYearOfWritting());
        prata.setYearOfWritting(2020);
        prata.setAuthor("Steven Prata");
        prata.setName("Prata c++ 2020");

        System.out.printf("Author: %s , Name: %s, Year of writting: %s",
                prata.getAuthor(), prata.getName(), prata.getYearOfWritting());
    }
}
