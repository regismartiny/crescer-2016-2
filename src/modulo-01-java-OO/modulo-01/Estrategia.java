import java.util.*;

public interface Estrategia
{
    List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes, List<Dwarf> alvos) throws ContingenteDesproporcionalException;
}
