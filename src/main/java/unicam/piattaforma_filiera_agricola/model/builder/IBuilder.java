package unicam.piattaforma_filiera_agricola.model.builder;

import java.util.Date;

public interface IBuilder {

    public void reset();

    public void BuildNomeProdotto(String nomeProdotto);

    public void BuildDescrizione(String descrizione);

    public void BuildProcesso(String processo);

    public void BuildCertificati(String certificati);

    public void BuildCosto(double costo);

    public void BuildQuantitativo(int quantitativo);

    public void BuildDataInserimento(Date dataInserimento);

}
