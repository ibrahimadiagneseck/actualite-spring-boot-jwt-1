package sn.esp.gestionUtilisateur.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import sn.esp.gestionUtilisateur.entities.FichierDB;
import sn.esp.gestionUtilisateur.repositories.FichierDBRepository;
import sn.esp.gestionUtilisateur.services.FichierStockageService;

import java.io.IOException;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class FichierStockageServiceImpl implements FichierStockageService {

    @Autowired
    private FichierDBRepository fichierDBRepository;

    public FichierDB store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        FichierDB FileDB = new FichierDB(fileName, file.getContentType(), file.getBytes());

        return fichierDBRepository.save(FileDB);
    }

    public FichierDB getFile(String id) {
        return fichierDBRepository.findById(id).get();
    }

    public FichierDB getFileByNom(String nom) {
        return fichierDBRepository.findByNom(nom);
    }

    public void deleteFile(String id) {
        fichierDBRepository.deleteById(id);
    }

    public Stream<FichierDB> getAllFiles() {
        return fichierDBRepository.findAll().stream();
    }


//	public FichierDB getFileById(String id) {
//		return fichierDBRepository.findByIdfichierdb(id);
//	}

    public Optional<FichierDB> getFileById(String id) {
        return fichierDBRepository.findById(id);
    }
}
