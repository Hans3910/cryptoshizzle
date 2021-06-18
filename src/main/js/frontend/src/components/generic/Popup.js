import React from "react";
import '../../style/popup.css';

const Popup = ({record, visible, x, y}) => visible &&
  <ul className="popup" style={{left: `${x}px`, top: `${y}px`}}>
    <li>{record.name}</li>
    <li>Like it</li>
    <li>Bookmark</li>
  </ul>

export default Popup