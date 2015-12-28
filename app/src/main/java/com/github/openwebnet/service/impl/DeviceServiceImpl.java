package com.github.openwebnet.service.impl;

import com.github.openwebnet.component.Injector;
import com.github.openwebnet.model.DeviceModel;
import com.github.openwebnet.repository.DeviceRepository;
import com.github.openwebnet.service.DeviceService;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DeviceServiceImpl implements DeviceService {

    @Inject
    DeviceRepository deviceRepository;

    public DeviceServiceImpl() {
        Injector.getApplicationComponent().inject(this);
    }

    @Override
    public Observable<String> addDevice(DeviceModel.Builder device) {
        return deviceRepository.add(device.build())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<List<DeviceModel>> findAllDevice() {
        return deviceRepository.findAll();
    }

}
