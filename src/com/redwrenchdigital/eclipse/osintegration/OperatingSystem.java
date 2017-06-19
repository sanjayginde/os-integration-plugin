package com.redwrenchdigital.eclipse.osintegration;

/**
 * Enumerated type to abstract operating system specifics.
 *
 * @author Sanjay Ginde
 *
 */
public enum OperatingSystem {

    WINDOWS {
        @Override
        public String getFileBrowserExecutable() {
            return "explorer";
        }
    },

    MACOSX {
        @Override
        public String getFileBrowserExecutable() {
            return "open";
        }
    },

    LINUX_GNOME {
        @Override
        public String getFileBrowserExecutable() {
            return "nautilus";
        }
    },

    LINUX_KDE {
        @Override
        public String getFileBrowserExecutable() {
            return "dolphin";
        }
    };

    abstract public String getFileBrowserExecutable();
}
