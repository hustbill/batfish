package org.batfish.representation.cisco;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

import org.batfish.datamodel.Ip;

public abstract class BgpPeerGroup implements Serializable {

   private static final long serialVersionUID = 1L;

   protected Boolean _active;

   protected Boolean _advertiseInactive;

   private Map<String, String> _afGroups;

   protected Boolean _allowAsIn;

   protected Ip _clusterId;

   protected Integer _defaultMetric;

   protected Boolean _defaultOriginate;

   protected String _defaultOriginateMap;

   protected Integer _defaultOriginateMapLine;

   protected String _description;

   protected Boolean _disablePeerAsCheck;

   protected Boolean _ebgpMultihop;

   private String _groupName;

   private int _groupNameLine;

   protected String _inboundPrefixList;

   protected Integer _inboundPrefixListLine;

   private String _inboundRoute6Map;

   protected Integer _inboundRoute6MapLine;

   protected String _inboundRouteMap;

   protected Integer _inboundRouteMapLine;

   private transient boolean _inherited;

   private Boolean _nextHopSelf;

   protected String _outboundPrefixList;

   protected Integer _outboundPrefixListLine;

   protected String _outboundRoute6Map;

   protected Integer _outboundRoute6MapLine;

   protected String _outboundRouteMap;

   protected Integer _outboundRouteMapLine;

   private String _peerSession;

   private int _peerSessionLine;

   protected Integer _remoteAs;

   protected Boolean _removePrivateAs;

   protected Boolean _routeReflectorClient;

   protected Boolean _sendCommunity;

   private boolean _sendExtendedCommunity;

   protected Boolean _shutdown;

   protected String _updateSource;

   protected int _updateSourceLine;

   public BgpPeerGroup() {
      _afGroups = new TreeMap<>();
   }

   public Boolean getActive() {
      return _active;
   }

   public Boolean getAdvertiseInactive() {
      return _advertiseInactive;
   }

   public Map<String, String> getAfGroups() {
      return _afGroups;
   }

   public Boolean getAllowAsIn() {
      return _allowAsIn;
   }

   public Ip getClusterId() {
      return _clusterId;
   }

   public Integer getDefaultMetric() {
      return _defaultMetric;
   }

   public Boolean getDefaultOriginate() {
      return _defaultOriginate;
   }

   public String getDefaultOriginateMap() {
      return _defaultOriginateMap;
   }

   public Integer getDefaultOriginateMapLine() {
      return _defaultOriginateMapLine;
   }

   public String getDescription() {
      return _description;
   }

   public Boolean getDisablePeerAsCheck() {
      return _disablePeerAsCheck;
   }

   public Boolean getEbgpMultihop() {
      return _ebgpMultihop;
   }

   public String getGroupName() {
      return _groupName;
   }

   public int getGroupNameLine() {
      return _groupNameLine;
   }

   public String getInboundPrefixList() {
      return _inboundPrefixList;
   }

   public Integer getInboundPrefixListLine() {
      return _inboundPrefixListLine;
   }

   public String getInboundRoute6Map() {
      return _inboundRoute6Map;
   }

   public Integer getInboundRoute6MapLine() {
      return _inboundRoute6MapLine;
   }

   public String getInboundRouteMap() {
      return _inboundRouteMap;
   }

   public Integer getInboundRouteMapLine() {
      return _inboundRouteMapLine;
   }

   public boolean getInherited() {
      return _inherited;
   }

   public abstract String getName();

   public Boolean getNextHopSelf() {
      return _nextHopSelf;
   }

   public String getOutboundPrefixList() {
      return _outboundPrefixList;
   }

   public Integer getOutboundPrefixListLine() {
      return _outboundPrefixListLine;
   }

   public String getOutboundRoute6Map() {
      return _outboundRoute6Map;
   }

   public Integer getOutboundRoute6MapLine() {
      return _outboundRoute6MapLine;
   }

   public String getOutboundRouteMap() {
      return _outboundRouteMap;
   }

   public Integer getOutboundRouteMapLine() {
      return _outboundRouteMapLine;
   }

   protected final BgpPeerGroup getParentGroup(BgpProcess proc,
         CiscoConfiguration cv) {
      BgpPeerGroup parent = null;
      if (_groupName != null) {
         parent = proc.getNamedPeerGroups().get(_groupName);
         BgpProcess defaultProc = cv.getDefaultVrf().getBgpProcess();
         if (parent == null) {
            parent = defaultProc.getNamedPeerGroups().get(_groupName);
         }
         if (parent == null) {
            cv.undefined(CiscoStructureType.BGP_PEER_GROUP, _groupName,
                  CiscoStructureUsage.BGP_INHERITED_GROUP, _groupNameLine);
         }
      }
      return parent;
   }

   protected final BgpPeerGroup getParentSession(BgpProcess proc,
         CiscoConfiguration cv) {
      BgpPeerGroup parent = null;
      if (_peerSession != null) {
         parent = proc.getPeerSessions().get(_peerSession);
         BgpProcess defaultProc = cv.getDefaultVrf().getBgpProcess();
         if (parent == null) {
            parent = defaultProc.getPeerSessions().get(_peerSession);
         }
         if (parent == null) {
            cv.undefined(CiscoStructureType.BGP_PEER_GROUP, _peerSession,
                  CiscoStructureUsage.BGP_INHERITED_SESSION, _peerSessionLine);
         }
      }
      if (parent == null) {
         parent = proc.getMasterBgpPeerGroup();
      }
      return parent;
   }

   public String getPeerSession() {
      return _peerSession;
   }

   public int getPeerSessionLine() {
      return _peerSessionLine;
   }

   public Integer getRemoteAs() {
      return _remoteAs;
   }

   public Boolean getRemovePrivateAs() {
      return _removePrivateAs;
   }

   public Boolean getRouteReflectorClient() {
      return _routeReflectorClient;
   }

   public Boolean getSendCommunity() {
      return _sendCommunity;
   }

   public boolean getSendExtendedCommunity() {
      return _sendExtendedCommunity;
   }

   public Boolean getShutdown() {
      return _shutdown;
   }

   public String getUpdateSource() {
      return _updateSource;
   }

   public int getUpdateSourceLine() {
      return _updateSourceLine;
   }

   private void inheritUnsetFields(BgpPeerGroup pg) {
      if (_active == null) {
         _active = pg.getActive();
      }
      if (_advertiseInactive == null) {
         _advertiseInactive = pg.getAdvertiseInactive();
      }
      if (_allowAsIn == null) {
         _allowAsIn = pg.getAllowAsIn();
      }
      if (_clusterId == null) {
         _clusterId = pg.getClusterId();
      }
      if (_defaultOriginate == null) {
         _defaultOriginate = pg.getDefaultOriginate();
      }
      if (_defaultOriginateMap == null) {
         _defaultOriginateMap = pg.getDefaultOriginateMap();
         _defaultOriginateMapLine = pg.getDefaultOriginateMapLine();
      }
      if (_description == null) {
         _description = pg.getDescription();
      }
      if (_disablePeerAsCheck == null) {
         _disablePeerAsCheck = pg.getDisablePeerAsCheck();
      }
      if (_ebgpMultihop == null) {
         _ebgpMultihop = pg.getEbgpMultihop();
      }
      if (_inboundPrefixList == null) {
         _inboundPrefixList = pg.getInboundPrefixList();
         _inboundPrefixListLine = pg.getInboundPrefixListLine();
      }
      if (_inboundRouteMap == null) {
         _inboundRouteMap = pg.getInboundRouteMap();
         _inboundRouteMapLine = pg.getInboundRouteMapLine();
      }
      if (_inboundRoute6Map == null) {
         _inboundRoute6Map = pg.getInboundRoute6Map();
         _inboundRoute6MapLine = pg.getInboundRoute6MapLine();
      }
      if (_nextHopSelf == null) {
         _nextHopSelf = pg.getNextHopSelf();
      }
      if (_outboundPrefixList == null) {
         _outboundPrefixList = pg.getOutboundPrefixList();
         _outboundPrefixListLine = pg.getOutboundPrefixListLine();
      }
      if (_outboundRouteMap == null) {
         _outboundRouteMap = pg.getOutboundRouteMap();
         _outboundRouteMapLine = pg.getOutboundRouteMapLine();
      }
      if (_outboundRoute6Map == null) {
         _outboundRoute6Map = pg.getOutboundRoute6Map();
         _outboundRoute6MapLine = pg.getOutboundRoute6MapLine();
      }
      if (_remoteAs == null) {
         _remoteAs = pg.getRemoteAs();
      }
      if (_routeReflectorClient == null) {
         _routeReflectorClient = pg.getRouteReflectorClient();
      }
      if (_sendCommunity == null) {
         _sendCommunity = pg.getSendCommunity();
      }
      if (_shutdown == null) {
         _shutdown = pg.getShutdown();
      }
      if (_updateSource == null) {
         _updateSource = pg.getUpdateSource();
      }
   }

   public void inheritUnsetFields(BgpProcess proc, CiscoConfiguration cv) {
      if (_inherited) {
         return;
      }
      _inherited = true;
      BgpPeerGroup aa = getParentGroup(proc, cv);
      if (aa != null) {
         aa.inheritUnsetFields(proc, cv);
         inheritUnsetFields(aa);
      }
      BgpPeerGroup pg = getParentSession(proc, cv);
      if (pg != null) {
         pg.inheritUnsetFields(proc, cv);
         inheritUnsetFields(pg);
      }
   }

   public void setActive(boolean active) {
      _active = active;
   }

   public void setAdvertiseInactive(boolean advertiseInactive) {
      _advertiseInactive = advertiseInactive;
   }

   public void setAllowAsIn(boolean allowAsIn) {
      _allowAsIn = allowAsIn;
   }

   public void setClusterId(Ip ip) {
      _clusterId = ip;
   }

   public void setDefaultMetric(int defaultMetric) {
      _defaultMetric = defaultMetric;
   }

   public void setDefaultOriginate(boolean b) {
      _defaultOriginate = true;
   }

   public void setDefaultOriginateMap(String routeMapName) {
      _defaultOriginateMap = routeMapName;
   }

   public void setDefaultOriginateMapLine(Integer defaultOriginateMapLine) {
      _defaultOriginateMapLine = defaultOriginateMapLine;
   }

   public void setDescription(String description) {
      _description = description;
   }

   public void setDisablePeerAsCheck(boolean disablePeerAsCheck) {
      _disablePeerAsCheck = disablePeerAsCheck;
   }

   public void setEbgpMultihop(boolean ebgpMultihop) {
      _ebgpMultihop = ebgpMultihop;
   }

   public void setGroupName(String groupName) {
      _groupName = groupName;
   }

   public void setGroupNameLine(int groupNameLine) {
      _groupNameLine = groupNameLine;
   }

   public void setInboundPrefixList(String inboundPrefixList) {
      _inboundPrefixList = inboundPrefixList;
   }

   public void setInboundPrefixListLine(Integer inboundPrefixListLine) {
      _inboundPrefixListLine = inboundPrefixListLine;
   }

   public void setInboundRoute6Map(String inboundRoute6Map) {
      _inboundRoute6Map = inboundRoute6Map;
   }

   public void setInboundRoute6MapLine(Integer inboundRoute6MapLine) {
      _inboundRoute6MapLine = inboundRoute6MapLine;
   }

   public void setInboundRouteMap(String name) {
      _inboundRouteMap = name;
   }

   public void setInboundRouteMapLine(Integer inboundRouteMapLine) {
      _inboundRouteMapLine = inboundRouteMapLine;
   }

   public void setNextHopSelf(boolean nextHopSelf) {
      _nextHopSelf = nextHopSelf;
   }

   public void setOutboundPrefixList(String listName) {
      _outboundPrefixList = listName;
   }

   public void setOutboundPrefixListLine(Integer outboundPrefixListLine) {
      _outboundPrefixListLine = outboundPrefixListLine;
   }

   public void setOutboundRoute6Map(String outboundRoute6Map) {
      _outboundRoute6Map = outboundRoute6Map;
   }

   public void setOutboundRoute6MapLine(Integer outboundRoute6MapLine) {
      _outboundRoute6MapLine = outboundRoute6MapLine;
   }

   public void setOutboundRouteMap(String name) {
      _outboundRouteMap = name;
   }

   public void setOutboundRouteMapLine(Integer outboundRouteMapLine) {
      _outboundRouteMapLine = outboundRouteMapLine;
   }

   public void setPeerSession(String peerSession) {
      _peerSession = peerSession;
   }

   public void setPeerSessionLine(int peerSessionLine) {
      _peerSessionLine = peerSessionLine;
   }

   public void setRemoteAs(int remoteAS) {
      _remoteAs = remoteAS;
   }

   public void setRemovePrivateAs(boolean removePrivateAs) {
      _removePrivateAs = removePrivateAs;
   }

   public void setRouteReflectorClient(boolean b) {
      _routeReflectorClient = b;
   }

   public void setSendCommunity(boolean sendCommunity) {
      _sendCommunity = sendCommunity;
   }

   public void setSendExtendedCommunity(boolean sendExtendedCommunity) {
      _sendExtendedCommunity = sendExtendedCommunity;
   }

   public void setShutdown(boolean shutdown) {
      _shutdown = shutdown;
   }

   public void setUpdateSource(String updateSource) {
      _updateSource = updateSource;
   }

   public void setUpdateSourceLine(int updateSourceLine) {
      _updateSourceLine = updateSourceLine;
   }

}
