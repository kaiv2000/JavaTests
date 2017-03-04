package JSON;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;


class Cat {

    @JsonProperty("alias")
     String name;
     int age;
    int weight;

    public static void main(String[] args) throws IOException
    {
        Cat cat = new Cat();
        cat.name = "Murka";
        cat.age = 5;
        cat.weight = 4;

        StringWriter writer = new StringWriter();  //писать результат сериализации будем во Writer(StringWriter)

        ObjectMapper mapper = new ObjectMapper(); //это объект Jackson, который выполняет сериализацию

        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);


        mapper.writeValue(writer, cat); // сама сериализация: 1-куда, 2-что

        String result = writer.toString(); //преобразовываем все записанное во StringWriter в строку
        System.out.println("from: " + result);

        // deserialization json:
        StringReader reader = new StringReader(result);
        Cat catFrom = mapper.readValue(reader, Cat.class);
        System.out.println("to: "+catFrom.name+" "+catFrom.age);

    }

}
