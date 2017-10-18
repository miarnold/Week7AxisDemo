package gov.weather;

import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import java.io.StringReader;

import static org.junit.Assert.*;

public class NdfdXMLBindingStubTest {
    @Test
    public void NDFDgen() throws Exception {
        NdfdXMLBindingStub binding = (NdfdXMLBindingStub) new NdfdXMLLocator().getndfdXMLPort();

        String response = binding.NDFDgen(555.0, 222.0,12, 10-12-2017, 10-05-2017, "Miles", WI,MI,WA);
        //assertEquals("result did not match what was expected","43.0798,-89.3875",response);
        String gen = unmarshallResult(response);
        assertEquals("???",gen);
    }

    @Test
    public void NDFDgenByDay() throws Exception {
    }

    @Test
    public void NDFDgenLatLonList() throws Exception {
        NdfdXMLBindingStub binding = (NdfdXMLBindingStub) new NdfdXMLLocator().getndfdXMLPort();

        String response = binding.latLonListZipCode("53711");
        //assertEquals("result did not match what was expected","43.0798,-89.3875",response);
        String latLong = unmarshallResult(response);
        assertEquals("43.0798,-89.3875",latLong);
    }

    @Test
    public void NDFDgenByDayLatLonList() throws Exception {
    }

    @Test
    public void gmlLatLonList() throws Exception {
    }

    @Test
    public void gmlTimeSeries() throws Exception {
    }

    @Test
    public void latLonListSubgrid() throws Exception {
    }

    @Test
    public void latLonListLine() throws Exception {
    }

    @Test
    public void latLonListZipCode() throws Exception {
    }

    @Test
    public void latLonListSquare() throws Exception {
    }

    @Test
    public void cornerPoints() throws Exception {
    }

    @Test
    public void latLonListCityNames() throws Exception {
    }


    private String unmarshallResult(String response) throws Exception {

        JAXBContext jaxbContext = JAXBContext.newInstance(DwmlType.class);
        try{
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            DwmlType dwml = (DwmlType) jaxbUnmarshaller.unmarshal(new StringReader(response));
            return dwml.getLatLonList();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;


    }

}