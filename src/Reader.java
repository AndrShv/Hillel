public class Reader {
    public static void main(String[] args){
        Reader Vova = new Reader();
        int cardNumber = 10;
        String faculty = "school №69";
        String dateOfBirth = "18.08.09";
        String phoneNumber = " 098-351-87-45";
        String fullName = "Петро B. B.";
        String bookTitle = " Війна і мир ";
        String borrowedBook = bookTitle;
        System.out.println("человек с имене " + fullName + "с номером карты" + cardNumber + "номер телевона: " +phoneNumber + "взял книгу " + borrowedBook);
        borrowedBook = (" взяв книгу " + bookTitle);
        if (borrowedBook != null) {
            System.out.println(fullName + "повернув книгу " + borrowedBook + " до бібліотеки");
        }else{
            System.out.println("У користувача немає позиченої книги");
        }
    }
}
