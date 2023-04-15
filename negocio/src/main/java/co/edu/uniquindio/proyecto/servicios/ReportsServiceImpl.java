package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.dtos.ReportProductDTO;
import co.edu.uniquindio.proyecto.dtos.ReportProductDTO;
import co.edu.uniquindio.proyecto.repositorios.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportsServiceImpl implements ReportsService{

    private final ProductRepo productRepo;

    public ReportsServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<ReportProductDTO> getReportProducts() {
        List<Object[]> reports = productRepo.getReportProduct();
        List<ReportProductDTO> list = new ArrayList<>();
        reports.forEach(objects -> {list.add(new ReportProductDTO(objects[0].toString(),Integer.parseInt(objects[1].toString()),Double.parseDouble(objects[2].toString()),Integer.parseInt(objects[3].toString())));});
        return list;
    }
}
