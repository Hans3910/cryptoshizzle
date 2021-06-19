import React from "react";
import '../../style/popup.css';
import notification from "../utils/Notification";

const Popup = ({record, visible, x, y}) => visible &&
  <ul className="popup" style={{left: `${x}px`, top: `${y}px`}}>
    <li>{record.name}</li>
    <li onClick={() => notification(`${record.name} liked.`, 'success')}>Like it</li>
    <li>Bookmark</li>
  </ul>

export default Popup