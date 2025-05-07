package com.oop.examples.composition;

import java.util.ArrayList;
import java.util.List;

import com.oop.examples.encapsulation.Person;
import com.oop.examples.shared.Fotografiable;
import com.oop.examples.shared.Picture;

// Lawyer contains a Person
class LawyerUsingComposition {
  private Person person;
  public String lawFirm;

  public LawyerUsingComposition(Person person, String lawFirm) {
    this.person = person;
  }

  public String getName() {
    return this.person.getName();
  }
}

class LawyerUsingInheritance extends Person {
  public String lawFirm;

  public LawyerUsingInheritance(String name, int age, String lawFirm) {
    super(name, age, "lawyer@example.com");
    this.lawFirm = lawFirm;
  }
}

public class Familiy implements Fotografiable {
  private List<Person> members;

  public Familiy() {
    this.members = new ArrayList<>(); // []
  }

  public Familiy(List<Person> members) {
    this.members = members;
  }

  public void addMember(Person person) {
    this.members.add(person);
  }

  public List<Person> getMembers() {
    return this.members;
  }

  public List<Person> getAdults() {
    List<Person> adults = new ArrayList<>();
    for (Person person : members) {
      if (person.getAge() > 18) {
        adults.add(person);
      }
    }
    return adults;
  }


  @Override
  public Picture takePicture() {
    return this.members.get(0).takePicture();
  }

  @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Family: {");
        for (Person member : members) {
            sb.append(member.toString()).append(", ");
        }
        if (!members.isEmpty()) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("}");
        return sb.toString();
    }
}
