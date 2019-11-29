package hu.me.lev;

public class Author {
    String name;
    int age;
    String writtenBook;

    public Author(String name, int age, String writtenBook) {
        this.name = name;
        this.age = age;
        this.writtenBook = writtenBook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getWrittenBook() {
        return writtenBook;
    }

    public void setWrittenBook(String writtenBook) {
        this.writtenBook = writtenBook;
    }

    @Override
    public String toString()
    {
        String s =  "Author{" +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", written book:=" + writtenBook +
                '}';
        return s;
    }
}
