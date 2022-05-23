package com.wsiiz.repairshop.servicing.application;

import com.wsiiz.repairshop.servicing.domain.service.Service;
import com.wsiiz.repairshop.servicing.domain.service.ServiceRepository;
import com.wsiiz.repairshop.servicing.domain.service.ServiceService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

  @Autowired
  ServiceRepository serviceRepository;

  @Autowired
  ServiceService serviceService;

  @GetMapping("/services")
  public ResponseEntity<List<Service>> getMany(
      @RequestParam(value = "description", required = false) String description) {
    if (description == null) {
      return ResponseEntity.ok(serviceRepository.findAll());
    } else {
      return ResponseEntity.ok(serviceRepository.findByDescription(description));
    }
  }

  @GetMapping("/services/{id}")
  public ResponseEntity<Service> getOne(@PathVariable("id") Long id) {

    Optional<Service> service = serviceRepository.findById(id);

    return service.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping("/services")
  public ResponseEntity<Service> addNew(@RequestBody Service service) {
    return ResponseEntity.created(null).body(serviceService.add(service));
  }

  @DeleteMapping("/services/{id}")
  public ResponseEntity<Service> remove(@PathVariable("id") Long id) {

    Optional<Service> service = serviceRepository.findById(id);

    if (service.isPresent()) {
      serviceRepository.deleteById(id);
      return ResponseEntity.ok(service.get());
    } else {
      return ResponseEntity.notFound().build();
    }
  }

}
