package com.appsonair.shakebug.models;

public class DeviceInfo {
    private final String deviceModel;
    private final String deviceOsVersion;
    private final String deviceBatteryLevel;
    private final String deviceScreenSize;
    private final String deviceOrientation;
    private final String environment;
    private final String deviceRegionCode;
    private final String deviceRegionName;
    private final String timestamp;
    private final String buildVersionNumber;
    private final String releaseVersionNumber;
    private final String bundleIdentifier;
    private final String appName;
    private final String deviceUsedStorage;
    private final String deviceTotalStorage;
    private final String deviceMemory;
    private final String appMemoryUsage;
    private final String appsOnAirSDKVersion;

    private DeviceInfo(Builder builder) {
        this.deviceModel = builder.deviceModel;
        this.deviceOsVersion = builder.deviceOsVersion;
        this.deviceBatteryLevel = builder.deviceBatteryLevel;
        this.deviceScreenSize = builder.deviceScreenSize;
        this.deviceOrientation = builder.deviceOrientation;
        this.environment = builder.environment;
        this.deviceRegionCode = builder.deviceRegionCode;
        this.deviceRegionName = builder.deviceRegionName;
        this.timestamp = builder.timestamp;
        this.buildVersionNumber = builder.buildVersionNumber;
        this.releaseVersionNumber = builder.releaseVersionNumber;
        this.bundleIdentifier = builder.bundleIdentifier;
        this.appName = builder.appName;
        this.deviceUsedStorage = builder.deviceUsedStorage;
        this.deviceTotalStorage = builder.deviceTotalStorage;
        this.deviceMemory = builder.deviceMemory;
        this.appMemoryUsage = builder.appMemoryUsage;
        this.appsOnAirSDKVersion = builder.appsOnAirSDKVersion;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public String getDeviceOsVersion() {
        return deviceOsVersion;
    }

    public String getDeviceBatteryLevel() {
        return deviceBatteryLevel;
    }

    public String getDeviceScreenSize() {
        return deviceScreenSize;
    }

    public String getDeviceOrientation() {
        return deviceOrientation;
    }

    public String getEnvironment() {
        return environment;
    }

    public String getDeviceRegionCode() {
        return deviceRegionCode;
    }

    public String getDeviceRegionName() {
        return deviceRegionName;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getBuildVersionNumber() {
        return buildVersionNumber;
    }

    public String getReleaseVersionNumber() {
        return releaseVersionNumber;
    }

    public String getBundleIdentifier() {
        return bundleIdentifier;
    }

    public String getAppName() {
        return appName;
    }

    public String getDeviceUsedStorage() {
        return deviceUsedStorage;
    }

    public String getDeviceTotalStorage() {
        return deviceTotalStorage;
    }

    public String getDeviceMemory() {
        return deviceMemory;
    }

    public String getAppMemoryUsage() {
        return appMemoryUsage;
    }

    public String getAppsOnAirSDKVersion() {
        return appsOnAirSDKVersion;
    }

    public static class Builder {
        private String deviceModel;
        private String deviceOsVersion;
        private String deviceBatteryLevel;
        private String deviceScreenSize;
        private String deviceOrientation;
        private String environment;
        private String deviceRegionCode;
        private String deviceRegionName;
        private String timestamp;
        private String buildVersionNumber;
        private String releaseVersionNumber;
        private String bundleIdentifier;
        private String appName;
        private String deviceUsedStorage;
        private String deviceTotalStorage;
        private String deviceMemory;
        private String appMemoryUsage;
        private String appsOnAirSDKVersion;

        public Builder setDeviceModel(String deviceModel) {
            this.deviceModel = deviceModel;
            return this;
        }

        public Builder setDeviceOsVersion(String deviceOsVersion) {
            this.deviceOsVersion = deviceOsVersion;
            return this;
        }

        public Builder setDeviceBatteryLevel(String deviceBatteryLevel) {
            this.deviceBatteryLevel = deviceBatteryLevel;
            return this;
        }

        public Builder setDeviceScreenSize(String deviceScreenSize) {
            this.deviceScreenSize = deviceScreenSize;
            return this;
        }

        public Builder setDeviceOrientation(String deviceOrientation) {
            this.deviceOrientation = deviceOrientation;
            return this;
        }

        public Builder setEnvironment(String environment) {
            this.environment = environment;
            return this;
        }

        public Builder setDeviceRegionCode(String deviceRegionCode) {
            this.deviceRegionCode = deviceRegionCode;
            return this;
        }

        public Builder setDeviceRegionName(String deviceRegionName) {
            this.deviceRegionName = deviceRegionName;
            return this;
        }

        public Builder setTimestamp(String timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder setBuildVersionNumber(String buildVersionNumber) {
            this.buildVersionNumber = buildVersionNumber;
            return this;
        }

        public Builder setReleaseVersionNumber(String releaseVersionNumber) {
            this.releaseVersionNumber = releaseVersionNumber;
            return this;
        }

        public Builder setBundleIdentifier(String bundleIdentifier) {
            this.bundleIdentifier = bundleIdentifier;
            return this;
        }

        public Builder setAppName(String appName) {
            this.appName = appName;
            return this;
        }

        public Builder setDeviceUsedStorage(String deviceUsedStorage) {
            this.deviceUsedStorage = deviceUsedStorage;
            return this;
        }

        public Builder setDeviceTotalStorage(String deviceTotalStorage) {
            this.deviceTotalStorage = deviceTotalStorage;
            return this;
        }

        public Builder setDeviceMemory(String deviceMemory) {
            this.deviceMemory = deviceMemory;
            return this;
        }

        public Builder setAppMemoryUsage(String appMemoryUsage) {
            this.appMemoryUsage = appMemoryUsage;
            return this;
        }

        public Builder setAppsOnAirSDKVersion(String appsOnAirSDKVersion) {
            this.appsOnAirSDKVersion = appsOnAirSDKVersion;
            return this;
        }

        public DeviceInfo build() {
            return new DeviceInfo(this);
        }
    }
}
