package org.beebiome.dataportal.api.core.service;

import org.beebiome.dataportal.api.core.model.ImportResult;
import org.beebiome.dataportal.api.core.model.BeeBiomeVersion;
import org.springframework.web.multipart.MultipartFile;

public interface ImportService {

    ImportResult importData(MultipartFile[] files, String pwd);

    BeeBiomeVersion addNewBeeBiomeVersion(String pwd);
}
